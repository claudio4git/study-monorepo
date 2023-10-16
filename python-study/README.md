BÁSICO
---
Comandos básicos python

DJANGO
---
- Python 3.7.3
- Django - Web framework
- pip - Gerenciamento de dependências
- virtualenv - Ambiente virtual controlado

### Ativar o ambiente viurtual
$ source env/bin/activate

$ pip install -r requirements.txt

### Criar base der dados
$ python manage.py migrate

$ python manage.py createsuperuser

### Executar o servidor (http://localhost:8000)
$ python manage.py runserver

FLASK
---

- Python
- pipenv - Gerenciamento de dependências e ambiente virtual controlado
- Flask - Web framework
- Flask-RESTFul - Boas práticas do REST com Flask framework
- SQLAlchemy - Extensão Flask para modelagem de entidades
- Marshmellow - Extensão Flask para serialização de objetos

### Ativar o ambiente virtual
$ pipenv shell

### Instalar as dependências
$ pipenv install

### Criar a base de dados
```
$ python
>> from restful import db
>> db.create_all()
>> exit()
```

### Executar o servidor (http://localhst:5000)
$ python restful.py
