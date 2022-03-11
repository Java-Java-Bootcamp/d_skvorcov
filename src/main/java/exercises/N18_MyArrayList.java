package exercises;

import java.util.*;

public class N18_MyArrayList {

    public static class MyList<E> implements List<E> {
        private Object[] data = new Object[5];
        private int size;

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean add(E e) {
            if (data.length == size) {
                data = Arrays.copyOf(data, (int)(data.length * 1.5));
            }
            new ArrayList<>();
            data[size++] = e;
            return true;
        }

        @Override
        public void clear() {
            for (int i = 0; i < size; ++i)
                data[i] = null;
            size = 0;
        }

        @Override
        public E get(int index) {
            if (index >= size || index < 0)
                throw new IndexOutOfBoundsException(index + " >= " + size);
            return (E)data[index];
        }

        @Override
        public E set(int index, E element) {
            if (index >= size)
                throw new IndexOutOfBoundsException(index + " >= " + size);
            data[index] = element;
            return element;
        }

        @Override
        public boolean contains(Object o) {
            for (int i = 0; i < size; i++)
                if(data[i].equals(o)) return true;
            return false;
        }



        @Override
        public Object[] toArray() {
            return data;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return (T[]) data;
        }

        @Override
        public boolean remove(Object o) {
            int index = indexOf(o);
            if(index>=0) {
                remove(index);
                return true;
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            for (Object element:c) {
                add((E) element);
            }
            return true;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            for (Object element:c) {
                remove((E) element);
            }
            return true;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(int index, E element) {
            if(size+1>data.length){
                data = Arrays.copyOf(data, (int) (data.length*1.5));
            }
            for(int i = index+1; i+1<size; i++){
                data[i] = data[i+1];
            }
            data[index] = element;
        }

        @Override
        public E remove(int index) {
            E ret = (E) data[index];
            for(int j = index; j+1<size; j++){
                data[j] = data[j+1];
            }
            return ret;
        }

        @Override
        public int indexOf(Object o) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(o)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (data[i].equals(o)) {
                    index = i;
                }
            }
            return index;
        }

        @Override
        public Iterator<E> iterator() {
            Iterator<E> i = new Iterator<E>() {
                int current = 0;

                @Override
                public boolean hasNext() {
                    return current+1<=data.length;
                }

                @Override
                public E next() {
                    return (E) data[current++];
                }
            };
            return i;
        }

        @Override
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            if(index>size || index<0){
                throw new IllegalArgumentException("Index is BAD!");
            }
            ListIterator<E> i = new ListIterator<E>() {
                int current = index;
                @Override
                public boolean hasNext() {
                    return current+1<=data.length;
                }

                @Override
                public E next() {
                    return (E) data[current++];
                }

                @Override
                public boolean hasPrevious() {
                    return current>=0;
                }

                @Override
                public E previous() {
                    return (E) data[current--];
                }

                @Override
                public int nextIndex() {
                    return current+1;
                }

                @Override
                public int previousIndex() {
                    return current-1;
                }

                @Override
                public void remove() {
                    MyList.this.remove(current);
                }

                @Override
                public void set(E e) {
                    MyList.this.set(current, e);
                }

                @Override
                public void add(E e) {
                    MyList.this.add(current, e);
                }
            };
            return i;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException();
        }
    }
}
