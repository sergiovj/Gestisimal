package gestisimal;

import java.util.ArrayList;

/*
 * Clase Almacén que realice el alta, baja, modificación, entrada de mercancía 
 * (incrementa unidades), salida de mercancía (decrementa unidades).
 * El estado será un ArrayList de artículos. Esta clase es un envoltorio de un ArrayList.
 * Su comportamiento será: añadir artículos (no puede haber dos artículos iguales), 
 * eliminar artículos, incrementar las existencias de un artículo 
 * (se delega en la clase Artículo),  decrementar las existencias de un artículo 
 * (nunca por debajo de cero, se delega en la clase Artículo), devolver un artículo 
 * (para mostrarlo). Para  listar el almacén podría devolverse una cadena con todos 
 * los artículos del almacén (toString).
 */

public class Almacen {
  private static ArrayList<Articulo> almacen = new ArrayList<Articulo>();
  
  /**
   * 
   * @param precioCompra
   * @param precioVenta
   * @param descripcion
   * @param numeroUnidades
   * @param stockSeguridad
   * @param stockMaximo
   * @throws NumeroNegativoException
   * @throws StockMaximoExcedidoException
   * @throws StockMinimoIncumplidoException
   * @throws ArticuloRepetidoException
   */

  public void alta(double precioCompra, double precioVenta, String descripcion, int numeroUnidades,
      int stockSeguridad, int stockMaximo) throws NumeroNegativoException,
      StockMaximoExcedidoException, StockMinimoIncumplidoException, ArticuloRepetidoException {
      Articulo articulo = new Articulo(precioCompra, precioVenta, descripcion, numeroUnidades,
          stockSeguridad, stockMaximo);
      if (!almacen.contains(articulo))
        almacen.add(articulo);
      else
        throw new ArticuloRepetidoException("El articulo introducido ya existe");

  }
/**
 * Elimina un articulo previamente introducido
 * @param articulo
 * @return
 * @throws CodigoNoValidoException
 */
  public boolean eliminar(int codigo) throws CodigoNoValidoException {
    return almacen.remove(new Articulo(codigo));

  }
  /**
   * 
   * @param cantidad
   * @param codigo
   * @return
   * @throws NumeroNegativoException
   * @throws StockMaximoExcedidoException
   * @throws StockMinimoIncumplidoException
   */
  
  public boolean incrementarCantidad(int cantidad, int codigo)
      throws NumeroNegativoException, StockMaximoExcedidoException,
      StockMinimoIncumplidoException, ArticuloInexistenteException {
    return buscarArticulo(codigo).incrementar(cantidad);
    
    
  }
  
  /**
   * 
   * @param cantidad
   * @param codigo
   * @return
   * @throws NumeroNegativoException
   * @throws StockMaximoExcedidoException
   * @throws StockMinimoIncumplidoException
   * @throws ArticuloInexistenteException 
   */
  public boolean decrementarCantidad(int cantidad, int codigo)
      throws NumeroNegativoException, StockMaximoExcedidoException,
      StockMinimoIncumplidoException, ArticuloInexistenteException {
    return buscarArticulo(codigo).decrementar(cantidad);
    }
    
/**
 * Devuelve la posición del articulo en el arraylist segun el codigo pasado
 * @param codigo
 * @return
 */
  public Articulo buscarArticulo(int codigo) throws ArticuloInexistenteException {
    try {
      return almacen.get(almacen.indexOf((new Articulo(codigo))));
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloInexistenteException("El codigo introducido no pertenece a ningun artículo");
    }
  }
  

  @Override
  public String toString() {
    return "[almacen=" + almacen + "]";
  }

}

