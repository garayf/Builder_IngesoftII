/* "Product" */
class Hamburguesa{
    private String pan = "";
    private String salsa = "";
    private String tipo = "";
    private String tipoDeCarne = "";

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setTipoDeCarne(String tipoC) {
        this.tipoDeCarne = tipoC;
    }
}

/* "Abstract Builder" */
abstract class HamburguesaBuilder {
    protected Hamburguesa hamburguesa;

    public Hamburguesa getHamburguesa() {
        return hamburguesa;
    }

    public void createNewHamburguesaProduct() {
        hamburguesa = new Hamburguesa();
    }

    public abstract void buildPan();
    public abstract void buildSalsa();
    public abstract void buildTipo();
    public abstract void buildTipoDeCarne();
}

/* "ConcreteBuilder" */
class DobleCarneHamburguesaBuilder extends HamburguesaBuilder {
    public void buildPan() {
        hamburguesa.setPan("Oregano");
    }

    public void buildSalsa() {
        hamburguesa.setSalsa("Mostaza");
    }

    public void buildTipo() {
        hamburguesa.setTipo("Doble Carne");
    }
    
    public void buildTipoDeCarne() {
        hamburguesa.setTipoDeCarne("Res");
    }
}

/* "ConcreteBuilder" */
class VegetarianaHamburguesaBuilder extends HamburguesaBuilder {
	public void buildPan() {
        hamburguesa.setPan("Integral");
    }

    public void buildSalsa() {
        hamburguesa.setSalsa("Mayonesa");
    }

    public void buildTipo() {
        hamburguesa.setTipo("Vegetariana");
    }
    
    public void buildTipoDeCarne() {
        hamburguesa.setTipoDeCarne("No tiene");
    }
}

/* "Director" */
class Chef {
    private HamburguesaBuilder hamburguesaBuilder;

    public void setHamburguesaBuilder(HamburguesaBuilder hb) {
        hamburguesaBuilder = hb;
    }

    public Hamburguesa getHamburguesa() {
        return hamburguesaBuilder.getHamburguesa();
    }

    public void constructHamburguesa() {
    	hamburguesaBuilder.createNewHamburguesaProduct();
    	hamburguesaBuilder.buildPan();
    	hamburguesaBuilder.buildSalsa();
    	hamburguesaBuilder.buildTipo();
    	hamburguesaBuilder.buildTipoDeCarne();
    }
}

/* Un cliente pidiendo una hamburguesa. */
public class HamburguesaBuilderDemo {
    public static void main(String[] args) {
        Chef pedro = new Chef();
        HamburguesaBuilder doblecarneHamburguesabuilder = new DobleCarneHamburguesaBuilder();
        HamburguesaBuilder vegetarianaHamburguesaBuilder = new VegetarianaHamburguesaBuilder();

        pedro.setHamburguesaBuilder( doblecarneHamburguesabuilder );
        pedro.constructHamburguesa();

        Hamburguesa corralisima = pedro.getHamburguesa();
    }
}
