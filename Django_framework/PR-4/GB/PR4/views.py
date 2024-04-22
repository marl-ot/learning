from django.http import HttpResponse
from django.shortcuts import render
from django.utils import timezone
from django.shortcuts import render, redirect
from .forms import ProductForm
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
    <p>Здесь вы можете узнать немного обо мне.</p>
    <p>Меня зовут Святослав.</p>
    """

    logging.info('Посещена страница "О себе"')
    
    return HttpResponse(html)


def ordered_products(request):
    end_date = timezone.now()
    start_date_7_days = end_date - timedelta(days=7)
    start_date_30_days = end_date - timedelta(days=30)
    start_date_365_days = end_date - timedelta(days=365)

    orders_7_days = Order.objects.filter(order_date__range=[start_date_7_days, end_date])
    orders_30_days = Order.objects.filter(order_date__range=[start_date_30_days, end_date])
    orders_365_days = Order.objects.filter(order_date__range=[start_date_365_days, end_date])


    ordered_products_7_days = set()
    ordered_products_30_days = set()
    ordered_products_365_days = set()

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


def add_product(request):
    if request.method == 'POST':
        form = ProductForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('home')
    else:
        form = ProductForm()
    return render(request, 'product_form.html', {'form': form})
