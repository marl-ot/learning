from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('orders/', views.ordered_products, name='orders'),
    path('add/', views.add_product, name='add_product'),
]
