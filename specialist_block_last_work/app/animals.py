class Animal:
    def __init__(self, name, command, birth_date):
        self.name = name
        self.command = command
        self.birth_date = birth_date

class DomesticAnimal(Animal):
    pass

class LivestockAnimal(Animal):
    pass

class Dog(DomesticAnimal):
    pass

class Cat(DomesticAnimal):
    pass

class Hamster(DomesticAnimal):
    pass

class Horse(LivestockAnimal):
    pass

class Camel(LivestockAnimal):
    pass

class Donkey(LivestockAnimal):
    pass
