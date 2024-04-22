from django.urls import path
from . import views

urlpatterns = [
    path('orders/', views.ordered_products, name='orders'),
    path('first_home/', views.home, name='home'),
    path('about/', views.about, name='about'),
    path('', views.add_product, name='add_product'),
]
