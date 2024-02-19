import pandas as pd 
import matplotlib.pyplot as plt 
 
# Загрузка данных 
# Предположим, что файл с данными называется 'weather_data.csv' 
df = pd.read_csv('weather_data.csv') 
 
# Предобработка данных 
# Удаление ненужных столбцов (пример) 
df = df[['Дата', 'Температура', 'Скорость ветра', 'Относительная влажность']] 
# Преобразование типов данных, если необходимо 
df['Дата'] = pd.to_datetime(df['Дата']) 
df['Температура'] = pd.to_numeric(df['Температура'], errors='coerce') 
df['Скорость ветра'] = pd.to_numeric(df['Скорость ветра'], errors='coerce') 
df['Относительная влажность'] = pd.to_numeric(df['Относительная влажность'], errors='coerce') 
 
# Визуализация данных 
plt.figure(figsize=(14, 7)) 
 
# График температуры 
plt.subplot(3, 1, 1) 
plt.plot(df['Дата'], df['Температура'], label='Температура') 
plt.title('Температура по датам') 
plt.xlabel('Дата') 
plt.ylabel('Температура, °C') 
plt.legend() 
 
# График скорости ветра 
plt.subplot(3, 1, 2) 
plt.plot(df['Дата'], df['Скорость ветра'], label='Скорость ветра', color='orange') 
plt.title('Скорость ветра по датам') 
plt.xlabel('Дата') 
plt.ylabel('Скорость ветра, м/с') 
plt.legend() 
 
# График относительной влажности 
plt.subplot(3, 1, 3) 
plt.plot(df['Дата'], df['Относительная влажность'], label='Относительная влажность', color='green') 
plt.title('Относительная влажность по датам') 
plt.xlabel('Дата') 
plt.ylabel('Относительная влажность, %') 
plt.legend() 
 
plt.tight_layout() 
plt.show()