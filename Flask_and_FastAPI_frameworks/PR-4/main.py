import sys
import time
import requests
import aiohttp
import asyncio


async def download_image_async(url):
    filename = url.split('/')[-1]
    async with aiohttp.ClientSession() as session:
        async with session.get(url) as response:
            async with open(filename, 'wb') as f:
                while True:
                    img = await response.content.read(1024)
                    if not img:
                        break
                    f.write(img)

    print(f"Изображение {filename} загружено")


async def async_main(urls):
    tasks = []
    for url in urls:
        task = asyncio.create_task(download_image_async(url))
        tasks.append(task)
    await asyncio.gather(*tasks)


def main():
    start_time = time.time()
    if len(sys.argv) < 2:
        print("Использование: python program.py <URL1> <URL2> ...")
        return

    urls = sys.argv[1:]

    asyncio.run(async_main(urls))

    end_time = time.time()
    total_time = end_time - start_time
    print(f"Общее время: {total_time} секунд")


if __name__ == "__main__":
    main()
