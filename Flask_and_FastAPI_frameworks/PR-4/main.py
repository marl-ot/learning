import time
import aiohttp
import asyncio


def get_urls_from_user():
    urls = []
    while True:
        url = input("Введите URL-адрес изображения (или введите 'all' для завершения): ")
        if url.lower() == 'all' or url == '':
            break
        urls.append(url)
    return urls


async def download_image_async(url):
    filename = url.split('/')[-1]
    async with aiohttp.ClientSession() as session:
        async with session.get(url) as response:
            async with open(filename, 'wb') as f:
                async for chunk in response.content.iter_chunked(1024):
                    f.write(chunk)

    print(f"Изображение {filename} загружено")


async def async_main(urls):
    await asyncio.gather(*(download_image_async(url) for url in urls))


def main():
    urls = get_urls_from_user()
    if not urls:
        print("Программа завершена")
        return
    
    start_time = time.time()

    asyncio.run(async_main(urls))

    end_time = time.time()
    total_time = end_time - start_time
    print(f"Общее время: {total_time} секунд")


if __name__ == "__main__":
    main()
