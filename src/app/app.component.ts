  import { Component, OnInit } from '@angular/core';
  import { Todo } from './todo';
  import { TodoService } from './todo.service';
  import { HttpErrorResponse } from '@angular/common/http';
  import { NgForm } from '@angular/forms';

  @Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
  })
  export class AppComponent implements OnInit{
    public lists?: Todo[];
    public editList?: Todo;
    public deleteList?: Todo;
    

    constructor(private todoService: TodoService){}

    ngOnInit() {
      this.getLists();
    }

    public getLists(): void {
      this.todoService.getAllLists().subscribe(
        (response: Todo[]) => {
          this.lists = response;
          console.log(this.lists);
        }, 
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public onAddList(addForm: NgForm): void {
      document.getElementById('add-employee-form')?.click();
      this.todoService.addList(addForm.value).subscribe(
        (response: Todo) => {
          console.log(response);
          this.getLists();
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
    }

    public onUpdateList(todo: Todo): void {
      this.todoService.updateList(todo).subscribe(
        (response: Todo) => {
          console.log(response);
          this.getLists();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public onDeleteList(todoId: number): void {
    this.todoService.deleteList(todoId).subscribe(
      (response: void) => {
        console.log(response);
        this.getLists();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  onCheckboxChange(todo: Todo) {
    this.todoService.updateList(todo).subscribe(() => {
    console.log('Todo updated successfully');
    }, error => {
    console.log('Error updating todo: ', error);
    });
    }
 

  public onOpenModal(todo:  Todo | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal'); 
    if (mode === 'add') {
      button.setAttribute('data-target', '#addListModal');
    }
    if (mode === 'edit') {
      this.editList = todo as Todo;
      button.setAttribute('data-target', '#updateListModal');
    }
    if (mode === 'delete') {
      this.deleteList = todo as Todo;
      button.setAttribute('data-target', '#deleteListModal');
    }
    container?.appendChild(button);
    button.click();
  }  
}
