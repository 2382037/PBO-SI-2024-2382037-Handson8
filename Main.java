import config.Database;
import entities.repositories.TodoListRepositoryDbImpl;
import entities.repositories.TodoListRepositoryImpl;
import repositories.TodoListRepository;
import entities.repositories.TodoListRepositoryImpl;
import entities.services.TodoListService;
import entities.service.TodoListServiceImpl;
import entities.views.TodoListTerminalView;
import entities.views.TodoListView; // Fixed typo


public class Main {
    public static void main(String[] args) {
        Database database = new Database("db_michael", "root", "", "Localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);


        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);


        TodoListView todoListView = (TodoListView) new TodoListTerminalView(todoListService);

        todoListView.run();
    }
}