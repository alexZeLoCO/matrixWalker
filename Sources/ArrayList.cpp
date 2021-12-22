//#include "../Headers/ArrayList.h"

template <class E>
class ArrayList
{
private:
    E *data;
    int size;
    int nElements;

public:
    template <E>
    ArrayList<E>::ArrayList()
    {
        this->size = 10;
        this->nElements = 0;
        this->data = (E *)malloc(10 * sizeof(E));
    }

    template <E>
    ArrayList<E>::ArrayList(int size)
    {
        this->size = size;
        this->nElements = 0;
        this->data = (E *)malloc(size * sizeof(E));
    }

    template <E>
    ArrayList<E>::ArrayList(int size, E *elements)
    {
        this->size = size;
        this->nElements = 0;
        this->data = (E *)malloc(size * sizeof(int));
        for (int i = 0; i < size; i++)
        {
            this->data[i] = elements[i];
        }
    }

    template <E>
    int ArrayList<E>::getSize()
    {
        return this->size;
    }

    template <E>
    void ArrayList<E>::setSize(int size)
    {
        if (size >= this.getSize())
        {
            this.size = size;
            E *neu;
            neu = (E *)malloc(size * sizeof(E));
            this->data = neu;
        }
    }

    template <E>
    int ArrayList<E>::getNElements()
    {
        return this->nElements;
    }

    template <E>
    bool ArrayList<E>::resize(int multiplier)
    {
        if (multiplier < 1)
        {
            return false;
        }
        this->size = this.getSize() * multiplier;
        this.setSize(this.getSize());
        return true;
    }

    template <E>
    bool ArrayList<E>::add(E e)
    {
        if (e == NULL)
        {
            return false;
        }
        if (this.contains(e))
        {
            return false;
        }
        if (this.getNElements() + 1 == this.getSize())
        {
            this.resize(2);
        }
        this->data[this.getNElements()] = e;
        this->nElements = this.getNElements() + 1;
        return true;
    }

    template <E>
    bool ArrayList<E>::remove(E e)
    {
        if (e == NULL)
        {
            return false;
        }
        if (!this.contains(e))
        {
            return false;
        }
        for (int i = 0; i < this.getNElements(); i++)
        {
            if (this.getData()[i] == e)
            {
                for (int j = i; j < this.getNElements() - i - 1; j++)
                {
                    this.getData()[j] = this.getData()[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    template <E>
    bool ArrayList<E>::contains(E e)
    {
        if (e == NULL)
        {
            return false;
        }
        for (int i = 0; i < this.getNElements(); i++)
        {
            if (this.getData()[i] == e)
            {
                return true;
            }
        }
        return false;
    }

    template <E>
    E ArrayList<E>::get(int idx)
    {
        if (idx < this.getNElements())
        {
            return this.getData()[idx];
        }
        return NULL;
    }

    template <E>
    void ArrayList<E>::show()
    {
        cout << "ArrayList of size: " << this.getSize() << " with " << this.getNElements() << " elements.\n";
        for (int i = 0; i < this.getNElements(); i++)
        {
            cout << this.getData()[i];
        }
        cout << "\n";
    }
};
