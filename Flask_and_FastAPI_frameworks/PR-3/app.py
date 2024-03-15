import os
from flask import Flask, render_template, redirect, url_for, request, session
from models import db, User
from flask_login import LoginManager, login_user, logout_user, current_user


app = Flask(__name__, template_folder='templates')
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.sqlite'
app.config['SECRET_KEY'] = 'b1591b09c0a92eae5c1e26b6fd0523f5e3e340d18c662aff2d2aae1bc2844a14'
login_manager = LoginManager()
login_manager.init_app(app)
db.init_app(app)


@app.route('/')
@app.route('/index/')
@app.route('/index.html/')
def index():
    context = {
        'page_name': 'Главная',
    }
    return render_template('index.html', **context)


@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))


@app.cli.command("init-db")
def init_db():
    db.create_all()
    print('status code: 200')


@app.route('/register/', methods=['GET', 'POST'])
@app.route('/register.html/', methods=['GET', 'POST'])
def register():
    if request.method == 'POST':
        
        first_name = request.form['first_name']
        last_name = request.form['last_name']
        email = request.form['email']
        password = request.form['password']
        
        new_user = User(first_name=first_name, last_name=last_name, email=email)
        new_user.set_password(password)
        
        db.session.add(new_user)
        db.session.commit()

        return redirect(url_for('login'))

    return render_template('registration.html')


@app.route('/login/', methods=['GET', 'POST'])
@app.route('/login.html/', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        email = request.form['email']
        password = request.form['password']
        
        user = User.query.filter_by(email=email).first()
        
        if user and user.check_password(password):
            login_user(user)
            return redirect(url_for('index'))
        else:
            error_message = "Неправильный email или пароль. Попробуйте еще раз."
            return render_template('login.html', error_message=error_message)
    
    return render_template('login.html')


@app.route('/logout/')
def logout():
    logout_user()
    return redirect(url_for('login'))


@app.route('/shoes/')
@app.route('/shoes.html/')
def shoes():
    _shoes = [{
              'title':'Голубые кеды',
              'desc' : 'Кеды голубого цвета',
              'img':'shoes_pic1.png',
              'alt' : 'кеды'},
             {'title': 'Красные кеды',
              'desc': 'Красные кеды',
              'img': 'shoes_pic2.png',
              'alt': 'кеды'},
             {'title': 'Синие кроссовки',
              'desc': 'Спортивные кроссовки',
              'img': 'shoes_pic3.png',
              'alt': 'кроссовки'}
             ]
    context = {'shoes': _shoes}
    return render_template('shoes.html', **context)


@app.route('/clothing/')
@app.route('/clothing.html/')
def clothing():
    _clothing = [{'title':'Футболка',
              'desc' : 'Черная футболка',
              'img':'clothing_pic1.jpg',
              'alt' : 'футболка'},
             {'title': 'Штаны',
              'desc': 'Зеленые штаны',
              'img': 'clothing_pic2.jpg',
              'alt': 'штаны'}
             ]
    context = {'clothing': _clothing}
    return render_template('clothing.html', **context)


@app.route('/jacket/')
@app.route('/jacket.html/')
def jacket():
    _jackets = [{'title':'Ветровка',
              'desc' : 'Бежевая мужская ветровка',
              'img':'jacket_pic1.jpg',
              'alt' : 'ветровка'}
             ]
    context = {'jackets': _jackets}
    return render_template('jacket.html', **context)


@app.route('/about/')
@app.route('/about.html/')
def about():
    context = {'page_name': 'О нас'}
    return render_template('about.html', **context)


@app.route('/contacts/')
@app.route('/contacts.html/')
def contacts():
    context = {'page_name': 'Контакты',
               'email': 'email@email.email',
               'site': 'http://127.0.0.1:5000',
               'location': 'Москва, Россия'}
    return render_template('contacts.html', **context)
