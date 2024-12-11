// import static package.class.InMemoryDB;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static class InMemoryDB {
    
        // private class vars
        private Map<String, Integer> entityA;
        private Map<String, Integer> entityB;
        private boolean inTransaction;

        // public access functions
        public InMemoryDB() {
            this.entityA = new HashMap<>();
            this.entityB = new HashMap<>();
            this.inTransaction = false;
        }

        public void begin_transaction() {
            if (inTransaction) {
                throw new IllegalStateException("ERROR: TRANSACTION ALREADY STARTED");
            }
            inTransaction = true;
            entityB = new HashMap<>();
        }

        public void put(String key, Integer value) {
            if (!inTransaction) {
                throw new IllegalStateException("ERROR: PLEASE START A TRANSACTION!");
            }
            entityB.put(key, value);
        }

        public Integer get(String key) {
            if (inTransaction && entityB.containsKey(key)) {
                return entityB.get(key);
            } else if (entityA.containsKey(key)) {
                return entityA.get(key);
            } else {
                return null;
            }
        }

        public void commit() {
            if (!inTransaction) {
                throw new IllegalStateException("ERROR: NO DATA TO COMMIT");
            }
            entityA.putAll(entityB);
            inTransaction = false;
            entityB = new HashMap<>();
        }

        public void rollback() {
            if (!inTransaction) {
                throw new IllegalStateException("ERROR: NO DATA TO ROLLBACK");
            }
            entityB = new HashMap<>();
            inTransaction = false;
        }
    }


    public static void main(String[] args) {
        
        InMemoryDB inmemoryDB = new InMemoryDB();

        System.out.println(inmemoryDB.get("A"));

        try {
            inmemoryDB.put("A", 5);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        inmemoryDB.begin_transaction();

        inmemoryDB.put("A", 5);

        System.out.println(inmemoryDB.get("A"));

        inmemoryDB.put("A", 6);

        inmemoryDB.commit();

        System.out.println(inmemoryDB.get("A"));

        try {
            inmemoryDB.commit();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            inmemoryDB.rollback();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(inmemoryDB.get("B"));

        inmemoryDB.begin_transaction();

        inmemoryDB.put("B", 10);

        inmemoryDB.rollback();

        System.out.println(inmemoryDB.get("B"));
    }
}