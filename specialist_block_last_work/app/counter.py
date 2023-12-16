class Counter:
    def __init__(self):
        self.value = 0

    def add(self):
        self.value += 1

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_value, traceback):
        self.value -= 1  # Уменьшаем счетчик при успешном завершении блока with
        if exc_type is not None:
            raise Exception("Ошибка работы с ресурсом")

