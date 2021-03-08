package gestisimal;

import java.util.Scanner;

public class TestAlmacen {

  public static void main(String[] args)
      throws NumeroNegativoException, StockMaximoExcedidoException,
      StockMinimoIncumplidoException, ArticuloRepetidoException, CodigoNoValidoException, ArticuloInexistenteException {

    int opcion;
    Menu menu = new Menu("Almacen",
        new String[] {"Alta de un articulo", "Incrementar articulo", "Decrementar existencias",
            "Mostrar articulo", "listar almacen", "eliminar artículo", "Salir"});
    Almacen almacen = new Almacen();
    do {
      opcion = menu.elegir();

      try {
        switch (opcion) {
          case 1:
            almacen.alta(pedirPrecioCompra(), pedirPrecioVenta(), pedirDescripcion(),
                pedirUnidades(), pedirStockSeguridad(), pedirStockMaximo());
            break;
          case 2:
            System.out.println(almacen.incrementarCantidad(pedirCantidad(), pedircodigo()));
            break;
          case 3:
            System.out.println(almacen.decrementarCantidad(pedirCantidad(), pedircodigo()));
            break;
          case 4:
            System.out.println(almacen.buscarArticulo(pedircodigo()));
            break;
          case 5:
            System.out.println(almacen);
            break;
          case 6:
            System.out.println(almacen.eliminar((pedircodigo())));
            break;
          case 7:
            System.out.println("Programa finalizado");
        }
      } catch (NumeroNegativoException e) {
        System.out.println(e.getMessage());
      } catch (StockMaximoExcedidoException e) {
        System.out.println(e.getMessage());
      } catch (StockMinimoIncumplidoException e) {
        System.out.println(e.getMessage());
      } catch (ArticuloRepetidoException e) {
        System.out.println(e.getMessage());
      } catch (CodigoNoValidoException e) {
        System.out.println(e.getMessage());
      } catch (ArticuloInexistenteException e) {
        System.out.println(e.getMessage());
        
      }
    } while (opcion != 7);

  }

  private static int pedirStockMaximo(){
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce el stock maximo:");
    return s.nextInt();
  }

  private static int pedirStockSeguridad(){
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce el stock de seguridad:");
    return s.nextInt();
  }

  private static int pedirUnidades(){
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce el numero de unidades:");
    return s.nextInt();
  }

  private static String pedirDescripcion(){
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce la descripción del articulo:");
    return s.nextLine();
  }

  private static double pedirPrecioCompra() {
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce el precio de compra del artículo:");
    return s.nextDouble();
  }

  private static double pedirPrecioVenta(){
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce el precio de venta del artículo:");
    return s.nextDouble();
  }

  private static int pedircodigo(){
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce el codigo del artículo :");
    return s.nextInt();
  }


  private static int pedirCantidad() {
    Scanner s = new Scanner(System.in);
    System.out.println("Introduce la cantidad :");
    return s.nextInt();
  }

}
