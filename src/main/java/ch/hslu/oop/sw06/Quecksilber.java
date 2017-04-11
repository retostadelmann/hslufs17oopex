package ch.hslu.oop.sw06;

/**
 *
 * @author reto.stadelmann
 */
public final class Quecksilber extends Element {

    public Quecksilber() {
        super();
        this.elementName = this.getElementName();
        this.setElementStateSwitchingPoints();
    }

    public Quecksilber(final double temperature) {
        super(temperature);
        this.elementName = this.getElementName();
        this.setElementStateSwitchingPoints();
    }
    
    @Override
    public final String getElementName() {
        return "Quecksilber";
    }
    
    @Override
    protected final void setElementStateSwitchingPoints(){
        this.stateSwitchPoints.put(AggregateState.Solid, -38.83);
        this.stateSwitchPoints.put(AggregateState.Liquid, 356d);
    }
}
