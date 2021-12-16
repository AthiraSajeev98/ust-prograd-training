import java.util.*;

public class NoteKeeper {

    PriorityQueue<String> todoListCompleted = new PriorityQueue<String>();
    PriorityQueue<String> todoListNotCompleted = new PriorityQueue<String>();
    PriorityQueue<String> todoList = new PriorityQueue<String>();
    ArrayList<String> removedList = new ArrayList<>();


    public void addList(String item, boolean completedOrNotCompleted) {
        if (completedOrNotCompleted) {
            todoListCompleted.add(item);
            todoList.addAll(todoListCompleted);
        } else {
            todoListNotCompleted.add(item);
            todoList.addAll(todoListNotCompleted);
        }import java.util.*;

        public class NoteKeeper {

            PriorityQueue<String> todoListCompleted = new PriorityQueue<String>();
            PriorityQueue<String> todoListNotCompleted = new PriorityQueue<String>();
            PriorityQueue<String> todoList = new PriorityQueue<String>();
            ArrayList<String> removedList = new ArrayList<>();


            public void addList(String item, boolean completedOrNotCompleted) {
                if (completedOrNotCompleted) {
                    todoListCompleted.add(item);
                    todoList.addAll(todoListCompleted);
                } else {
                    todoListNotCompleted.add(item);
                    todoList.addAll(todoListNotCompleted);
                }

            }

            public String checkList(String item) {
                String existingItem = null;
                for (String list : todoList) {
                    if (list == item) {
                        existingItem = item;
                        break;
                    }
                }
                return existingItem;
            }

            public boolean removeList(String item) {
//        boolean task = false;
                return todoList.removeIf(list -> list == item);

//        for (String list : todoList) {
//            if (list == item) {
//                task = false;
//            } else {
//                task = true;
//            }
//        }
//        return task;
            }

            public boolean unRemoveList(String item) {
                boolean task = false;
                removedList.add(item);
                todoList.removeIf(list -> list == item);
                todoList.addAll(removedList);
                if (todoList.contains(item)) {
                    task = true;
                }
                return task;
            }

            public boolean completedOrNotCompleted(String completedOrNotCompletedList) {
                boolean task = false;
                for (String list : todoListCompleted) {
                    if (list == completedOrNotCompletedList) {
                        task = true;
                    }
                }
                for (String list : todoListNotCompleted) {
                    if (list == completedOrNotCompletedList) {
                        task = false;
                    }

                }
                return task;
            }
        }


    }

    public String checkList(String item) {
        String existingItem = null;
        for (String list : todoList) {
            if (list == item) {
                existingItem = item;
                break;
            }
        }
        return existingItem;
    }


    public boolean removeList(String item) {
//        boolean task = false;
        return todoList.removeIf(list -> list == item);

//        for (String list : todoList) {
//            if (list == item) {
//                task = false;
//            } else {
//                task = true;
//            }
//        }
//        return task;
    }


    public boolean unRemoveList(String item) {
        boolean task = false;
        removedList.add(item);
        todoList.removeIf(list -> list == item);
        todoList.addAll(removedList);
        if (todoList.contains(item)) {
            task = true;
        }
        return task;
    }

    public boolean completedOrNotCompleted(String completedOrNotCompletedList) {
        boolean task = false;
        for (String list : todoListCompleted) {
            if (list == completedOrNotCompletedList) {
                task = true;
            }
        }
        for (String list : todoListNotCompleted) {
            if (list == completedOrNotCompletedList) {
                task = false;
            }

        }
        return task;
    }


}
