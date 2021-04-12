package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorProductos {

    private ArrayList<producto> lista;

    public GestorProductos() {
        lista = new ArrayList<producto>();
    }

    public ArrayList<producto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<producto> lista) {
        this.lista = lista;
    }
    
    public void insertarproducto(producto item)
    {
        lista.add(item);
    }
    
    public void modificarproducto(int pos, producto item)
    {
        lista.set(pos, item);
    }
    
    public void eliminarproducto(int pos)
    {
        lista.remove(pos);
    }
    
    public int obtieneId()
    {
        int idaux = 0;
        for(producto item : lista){
            idaux = item.getId();
        }
        return idaux +1;
    }
    
    public int ubicarproducto(int id)
    {
        int pos = -1;
        Iterator<producto> it = lista.iterator();
        while (it.hasNext ()){
            ++pos;
            producto aux = it.next();
            if(aux.getId() == id){
                break;
            }
        }
        return pos;
    }
}
