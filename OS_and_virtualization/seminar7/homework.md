# Задание

- Установить в виртуальную машину или VDS Docker, настроить набор контейнеров через docker compose по инструкции. (Часть с настройкой certbot и HTTPS опустить, если у вас нет настоящего домена и белого IP)
- Запустить два контейнера, связанные одной сетью (используя документацию).
Первый контейнер БД (например, образ mariadb:10.8), второй контейнер — phpmyadmin.
Получить доступ к БД в первом контейнере через второй контейнер (веб-интерфейс phpmyadmin).

# Выполнение

## Команды

    $ mkdir wordpress && cd wordpress

    $ mkdir nginx-conf

    $ nano nginx-conf/nginx.conf

    server {
        listen 80;
        listen [::]:80;

        server_name localhost;

        index index.php index.html index.htm;

        root /var/www/html;

        location ~ /.well-known/acme-challenge {
                allow all;
                root /var/www/html;
        }

        location / {
                try_files $uri $uri/ /index.php$is_args$args;
        }

        location ~ \.php$ {
                try_files $uri =404;
                fastcgi_split_path_info ^(.+\.php)(/.+)$;
                fastcgi_pass wordpress:9000;
                fastcgi_index index.php;
                include fastcgi_params;
                fastcgi_param SCRIPT_FILENAME $document_root$fastcgi_script_name;
                fastcgi_param PATH_INFO $fastcgi_path_info;
        }

        location ~ /\.ht {
                deny all;
        }

        location = /favicon.ico {
                log_not_found off; access_log off;
        }
        location = /robots.txt {
                log_not_found off; access_log off; allow all;
        }
        location ~* \.(css|gif|ico|jpeg|jpg|js|png)$ {
                expires max;
                log_not_found off;
        }
    }

    $ nano docker-compose.yml

    version: '3'

    services:
    db:
        image: mysql:8.0
        container_name: db
        restart: unless-stopped
        env_file: .env
        environment:
        - MYSQL_DATABASE=wordpress
        volumes:
        - dbdata:/var/lib/mysql
        command: '--default-authentication-plugin=mysql_native_password'
        networks:
        - app-network

    wordpress:
        depends_on:
        - db
        image: wordpress:5.1.1-fpm-alpine
        container_name: wordpress
        restart: unless-stopped
        env_file: .env
        environment:
        - WORDPRESS_DB_HOST=db:3306
        - WORDPRESS_DB_USER=$MYSQL_USER
        - WORDPRESS_DB_PASSWORD=$MYSQL_PASSWORD
        - WORDPRESS_DB_NAME=wordpress
        volumes:
        - wordpress:/var/www/html
        networks:
        - app-network

    webserver:
        depends_on:
        - wordpress
        image: nginx:1.15.12-alpine
        container_name: webserver
        restart: unless-stopped
        ports:
        - "80:80"
        volumes:
        - wordpress:/var/www/html
        - ./nginx-conf:/etc/nginx/conf.d
        - certbot-etc:/etc/letsencrypt
        networks:
        - app-network

    certbot:
        depends_on:
        - webserver
        image: certbot/certbot
        container_name: certbot
        volumes:
        - certbot-etc:/etc/letsencrypt
        - wordpress:/var/www/html
        command: certonly --webroot --webroot-path=/var/www/html --email sammy@example.com --agree-tos --no-eff-email --staging -d localhost

    volumes:
    certbot-etc:
    wordpress:
    dbdata:

    networks:
    app-network:
        driver: bridge 

    $ docker-compose up -d

Набор docker-composes:

![](./images/docker-compose-up-d.png)

![](./images/ready.png)