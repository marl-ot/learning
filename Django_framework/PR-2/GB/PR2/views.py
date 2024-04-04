from django.shortcuts import render
from django.http import HttpResponse
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
