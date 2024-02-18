import os
from collections import namedtuple
import logging


logging.basicConfig(filename='directory_info.log',
                    level=logging.INFO, format='%(asctime)s - %(message)s')


FileInfo = namedtuple(
    'FileInfo', ['name', 'extension', 'is_directory', 'parent_directory'])


class DirectoryProcessor:
    def __init__(self, directory_path):
        self.directory_path = directory_path

    def process_directory(self):
        directory_info_list = []
        try:
            with os.scandir(self.directory_path) as entries:
                for entry in entries:
                    name, extension = os.path.splitext(entry.name)
                    is_directory = entry.is_dir()
                    parent_directory = os.path.basename(
                        os.path.dirname(entry.path))
                    file_info = FileInfo(
                        name, extension, is_directory, parent_directory)
                    directory_info_list.append(file_info)
                    logging.info(
                        f"Name: {name}, Extension: {extension}, Is Directory: {is_directory}, Parent Directory: {parent_directory}")

        except FileNotFoundError:
            logging.error(f"Directory not found: {self.directory_path}")
        except Exception as e:
            logging.error(f"Error processing directory: {e}")

        return directory_info_list


def main():
    directory_path = input("Введите путь к директории: ")
    if not os.path.exists(directory_path) or not os.path.isdir(directory_path):
        print(
            f"Указанный путь не является директорией или не существует: {directory_path}")
        return

    directory_processor = DirectoryProcessor(directory_path)
    directory_info_list = directory_processor.process_directory()
    for file_info in directory_info_list:
        print(file_info)


if __name__ == "__main__":
    main()
