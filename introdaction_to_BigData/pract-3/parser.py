import pandas as pd
import matplotlib.pyplot as plt

def parse_weather_csv(file_path):

    df = pd.read_csv(file_path, encoding='ansi', delimiter=';')

    # Построение графика изменения температуры
    plt.figure(figsize=(10, 5))
    plt.plot(df['Дата'], df['T'], label='Температура')
    plt.title('Изменение температуры')
    plt.xlabel('Время')
    plt.ylabel('Температура, °C')
    plt.legend()
    plt.show()

    # Построение графика распределения температуры
    plt.figure(figsize=(8, 5))
    plt.hist(df['T'], bins=20, color='skyblue', edgecolor='black')
    plt.title('Распределение температуры')
    plt.xlabel('Температура, °C')
    plt.ylabel('Частота')
    plt.show()

parse_weather_csv('./data/Германия.Берлин.csv')
parse_weather_csv('./data/Италия.Рим.csv')
parse_weather_csv('./data/ОАЭ.Абудаби.csv')
parse_weather_csv('./data/Россия.Москва.csv')
parse_weather_csv('./data/Франция.Париж.csv')
