/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int tail = -1;

    void clear() {
        int i = 0;
        while (i <= tail) {
            storage[i++] = null;
        }
        tail = -1;
    }

    void save(Resume r) {
        storage[++tail] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i <= tail; i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        int deleteIndex = -1;
        for (int i = 0; i <= tail; i++) {
            if (storage[i].uuid.equals(uuid)) {
                deleteIndex = i;
                storage[i] = null;
                break;
            }
        }
        if (deleteIndex > -1) {
            storage[deleteIndex] = storage[tail];
            tail--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if ( tail == -1 ) return new Resume[0];
        Resume[] r = new Resume[tail + 1];
        for (int i = 0; i <= tail; i++) {
            r[i] = storage[i];
        }
        return r;
    }

    int size() {
        if ( tail > -1)
            return tail + 1;
        else
            return 0;
    }
}
