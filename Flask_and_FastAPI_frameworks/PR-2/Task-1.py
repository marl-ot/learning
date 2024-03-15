from flask import Flask, render_template, request, redirect, url_for, make_response

app = Flask(__name__, template_folder='templates')
app.secret_key = 'f3cfe9ed8fae309f02079dbf'


@app.route('/')
@app.route('/index/')
@app.route('/index.html/')
def index():
    context = {
                'page_name': 'Главная'
              }
    return render_template('index.html', **context)


@app.route('/login/', methods=['GET', 'POST'])
@app.route('/login.html/', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form['username']
        email = request.form['email']
        resp = make_response(redirect(url_for('welcome')))
        resp.set_cookie('username', username)
        resp.set_cookie('email', email)
        print("Куки установлены:", resp.headers.getlist('Set-Cookie'))
        return resp
    return render_template('login.html')


@app.route('/welcome/')
@app.route('/welcome.html/')
def welcome():
    username = request.cookies.get('username')
    if username:
        return render_template('welcome.html', username=username)
    else:
        return redirect(url_for('login'))


@app.route('/logout/', methods=['GET', 'POST'])
@app.route('/logout.html/', methods=['GET', 'POST'])
def logout():
    if request.method == 'POST':
        resp = make_response(redirect(url_for('login')))
        resp.delete_cookie('username')
        resp.delete_cookie('email')
        print("Куки удалены:", resp.headers.getlist('Set-Cookie'))
        return resp
    else:
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


if __name__ == '__main__':
    app.run(debug=True)