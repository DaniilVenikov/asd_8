public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int sum = 0;
        for(int i = 0; i < value.length(); i++) {
            sum += value.charAt(i);
        }

        return sum % size;
    }

    public int seekSlot(String value)
    {
        int firstIndex = hashFun(value);
        int resultIndex = firstIndex;

        do {
            if (slots[resultIndex] == null) {
                return resultIndex;
            }
            resultIndex = (resultIndex + step) % size;
        } while (resultIndex != firstIndex);

        return -1;
    }

    public int put(String value)
    {
        int index = seekSlot(value);

        if (index == -1) {
            return -1;
        } else {
            slots[index] = value;
            return index;
        }
    }

    public int find(String value)
    {
        int firstIndex = hashFun(value);
        int resultIndex = firstIndex;

        do {
            if (slots[resultIndex] != null && slots[resultIndex].equals(value)) {
                return resultIndex;
            }
            resultIndex = (resultIndex + step) % size;
        } while (firstIndex != resultIndex);

        return -1;
    }
}

