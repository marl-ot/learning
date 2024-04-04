from django.http import HttpResponse
from django.shortcuts import render
from django.utils import timezone
from datetime import timedelta
from .models import Order
import logging


logging.basicConfig(filename='access.log', level=logging.INFO)


def home(request):
    html = """
    <h1>Добро пожаловать на мой первый Django-сайт!</h1>
    <p>Это главная страница сайта.</p>
    <p>Меня зовут, Святослав.</p>
    """
    
    logging.info('Посещена главная страница')
    
    return HttpResponse(html)


def about(request):
    html = """
    <h1>Обо мне</h1>
    <p>Здесь вы можете узнать немного о мне.</p>
    <p>Меня зовут Святослав.</p>
    """

    logging.info('Посещена страница "О себе"')
    
    return HttpResponse(html)


def ordered_products(request):
    # Определяем даты начала и конца периода
    end_date = timezone.now()
    start_date_7_days = end_date - timedelta(days=7)
    start_date_30_days = end_date - timedelta(days=30)
    start_date_365_days = end_date - timedelta(days=365)

    # Получаем заказы клиента за указанные периоды
    orders_7_days = Order.objects.filter(order_date__range=[start_date_7_days, end_date])
    orders_30_days = Order.objects.filter(order_date__range=[start_date_30_days, end_date])
    orders_365_days = Order.objects.filter(order_date__range=[start_date_365_days, end_date])

    # Создаем множество для хранения уникальных товаров
    ordered_products_7_days = set()
    ordered_products_30_days = set()
    ordered_products_365_days = set()

    # Добавляем уникальные товары из каждого заказа в множество
    for order in orders_7_days:
        ordered_products_7_days.update(order.products.all())
    for order in orders_30_days:
        ordered_products_30_days.update(order.products.all())
    for order in orders_365_days:
        ordered_products_365_days.update(order.products.all())

    context = {
        'ordered_products_7_days': ordered_products_7_days,
        'ordered_products_30_days': ordered_products_30_days,
        'ordered_products_365_days': ordered_products_365_days,
    }

    return render(request, 'ordered_products.html', context)
