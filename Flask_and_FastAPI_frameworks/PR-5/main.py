from fastapi import FastAPI, HTTPException, Query
from pydantic import BaseModel
import uuid
from typing import Annotated

app = FastAPI()

class Task(BaseModel):
    id: uuid.UUID
    description: str

tasks: list[Task] = [
    Task(id = uuid.uuid4(), description='Помыть посуду'),
    Task(id = uuid.uuid4(), description='Сделать домашку'),
    Task(id = uuid.uuid4(), description='Купить еды'),
    Task(id = uuid.uuid4(), description='Сделать проект'),
]

@app.post('/tasks/add')
async def add_task(description: Annotated[str | None, Query(min_length=4)] = None):
    task = Task(id = uuid.uuid4(), description= description)
    tasks.append(task)
    return

@app.get('/tasks/')
async def get_tasks():
    return tasks

@app.get('/task/{task_id}')
async def get_task(task_id : uuid.UUID | None):
    for task in tasks:
        if task.id == task_id:
            return task
    return HTTPException(status_code=404, detail='task not found')
        
@app.delete('/task/delete')
async def task_delete(task_id : uuid.UUID | None):
    if task_id == None:
        return 'Nothing to delete'
    for task in tasks:
        if task.id == task_id:
            tasks.remove(task)
            return "Delete Completed!!!!"
        

@app.put('/task/update')
async def task_update(task_id : uuid.UUID | None, descripton: str | None):
    if task_id == None:
        return 'Nothing to update'
    if descripton == None:
        return 'No description handled'
    for task in tasks:
        if task.id == task_id:
            task.description = descripton
            return "Uptade Completed!!!!"
