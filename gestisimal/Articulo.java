package gestisimal;


/*
 * Clase Art�culo que representa a los art�culos del almac�n. Su estado ser�: c�digo, descripci�n,
 * precio de compra, precio de venta, n�mero de unidades (nunca negativas), stock de seguridad y
 * stock m�ximo. Como comportamiento: Consideramos que el c�digo va a generarse de forma autom�tica
 * en el constructor, as� no puede haber dos art�culos con el mismo c�digo. Esto implica que no
 * puede modificarse el c�digo de un art�culo, s� el resto de las propiedades. Podremos mostrar el
 * art�culo, por lo que necesito una representaci�n del art�culo en forma de cadena (toString).
 */

/**
 * 
 * @author Sergio Vera Jurado
 * @version 1.0
 * 
 */
public class Articulo {
  static int codigoGenerar = 0;
  int codigo;
  double precioCompra;
  double precioVenta;
  String descripcion;
  int numeroUnidades;
  int stockSeguridad;
  int stockMaximo;

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
   */
  public Articulo(double precioCompra, double precioVenta, String descripcion, int numeroUnidades,
      int stockSeguridad, int stockMaximo)
      throws NumeroNegativoException, StockMaximoExcedidoException, StockMinimoIncumplidoException {
    setCodigo();
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setDescripcion(descripcion);
    setStockSeguridad(stockSeguridad);
    setStockMaximo(stockMaximo);
    setNumeroUnidades(numeroUnidades);
  }

  public Articulo(int codigo) {
    this.codigo = codigo;
  }

  public int getCodigo() {
    return codigo;
  }

  private int setCodigo() {
    codigoGenerar += 1;
    return this.codigo = codigoGenerar;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  private void setPrecioCompra(double precioCompra) throws NumeroNegativoException {
    if (precioCompra < 0) {
      throw new NumeroNegativoException("El precio de compra no puede ser negativo");
    }
    this.precioCompra = precioCompra;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  private void setPrecioVenta(double precioVenta) throws NumeroNegativoException {
    if (precioVenta < 0) {
      throw new NumeroNegativoException("El precio de venta no puede ser negativo");
    }
    this.precioVenta = precioVenta;
  }

  public String getDescripcion() {
    return descripcion;
  }

  private void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getNumeroUnidades() {
    return numeroUnidades;
  }

  private boolean setNumeroUnidades(int cantidad)
      throws NumeroNegativoException, StockMaximoExcedidoException, StockMinimoIncumplidoException {
    if (cantidad < 0) {
      throw new NumeroNegativoException(
          "Las existencias no pueden ser negativas, el art�culo no ha sido creado");
    } else if (cantidad > this.stockMaximo) {
      throw new StockMaximoExcedidoException(
          "Has superado el stock maximo, el art�culo no ha sido creado");
    } else if (cantidad < this.stockSeguridad) {
      throw new StockMinimoIncumplidoException(
          "No cumples con el stock minimo, el art�culo no ha sido creado ");
    } else {
      this.numeroUnidades = cantidad;
      return true;
    }
  }

  public int getStockSeguridad() {
    return stockSeguridad;
  }

  private void setStockSeguridad(int stockSeguridad) {
    this.stockSeguridad = stockSeguridad;
  }

  public int getStockMaximo() {
    return stockMaximo;
  }

  private void setStockMaximo(int stockMaximo) {
    this.stockMaximo = stockMaximo;
  }

  /**
   * Este metodo incremente el numero de unidades de un art�culo
   * 
   * @param cantidadAIncrementar
   * @return
   * @throws NumeroNegativoException
   * @throws StockMaximoExcedidoException
   * @throws StockMinimoIncumplidoException
   */
  public boolean incrementar(int cantidadAIncrementar)
      throws NumeroNegativoException, StockMaximoExcedidoException, StockMinimoIncumplidoException {
    if (cantidadAIncrementar<0)
      throw new NumeroNegativoException("No puedes incrementar usando numeros negativos");
    return setNumeroUnidades(getNumeroUnidades() + cantidadAIncrementar);


  }

  /**
   * Este metodo decrementa las unidades disponibles de un art�culo
   * 
   * @param cantidadADecrementar
   * @return
   * @throws NumeroNegativoException
   * @throws StockMaximoExcedidoException
   * @throws StockMinimoIncumplidoException
   */

  public boolean decrementar(int cantidadADecrementar)
      throws NumeroNegativoException, StockMaximoExcedidoException, StockMinimoIncumplidoException {
    if (cantidadADecrementar<0)
      throw new NumeroNegativoException("No puedes decrementar usando numeros negativos");
    return setNumeroUnidades(this.getNumeroUnidades() - cantidadADecrementar);

  }


  @Override
  public String toString() {
    return "Articulo [codigo=" + codigo + ", precioCompra=" + precioCompra + ", precioVenta="
        + precioVenta + ", descripcion=" + descripcion + ", numeroUnidades=" + numeroUnidades
        + ", stockSeguridad=" + stockSeguridad + ", stockMaximo=" + stockMaximo + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }


}
