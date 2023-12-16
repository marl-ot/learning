from animals import *
from counter import Counter

def main():
    counter = Counter()

    try:
        with counter:
            animal = create_animal()
            if animal:
                print_animal_info(animal)
                counter.add()

    except Exception as e:
        print(f"Произошла ошибка: {e}")

def create_animal():
    name = input("Введите имя животного: ")
    command = input("Введите команду для животного: ")
    birth_date = input("Введите дату рождения (гггг-мм-дд): ")

    animal = Animal(name, command, birth_date)
    return animal

def print_animal_info(animal):
    print(f"Имя: {animal.name}")
    print(f"Команда: {animal.command}")
    print(f"Дата рождения: {animal.birth_date}")

if __name__ == "__main__":
    main()

