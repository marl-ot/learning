from flask import Flask, render_template

app = Flask(__name__, template_folder='templates')


@app.route('/')
@app.route('/index/')
@app.route('/index.html/')
def index():
    context = {
                'page_name': 'Главная'
              }
    return render_template('index.html', **context)


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


if __name__ == '__main__':
    app.run(debug=True)