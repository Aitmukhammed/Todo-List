import { Injectable } from '@angular/core';
import { HttpClient } from'@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from './todo';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class TodoService {
    private apiServerUrl = environment.apiBaseUrl;

    // Можем сделать http запросы к бэкенду
    constructor(private http: HttpClient){ }

    public getAllLists(): Observable<Todo[]> {
        return this.http.get<Todo[]>(`${this.apiServerUrl}/todoList/all`);
    }

    public addList(todo: Todo): Observable<Todo> {
        return this.http.post<Todo>(`${this.apiServerUrl}/todoList/add`, todo);
    }
    
    public updateList(todo: Todo): Observable<Todo> {
        return this.http.put<Todo>(`${this.apiServerUrl}/todoList/update`, todo);
    }

    public deleteList(todoId: number): Observable<void> {
      return this.http.delete<void>(`${this.apiServerUrl}/todoList/delete/${todoId}`);
    }
}