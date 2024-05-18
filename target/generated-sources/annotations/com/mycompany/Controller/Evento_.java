package com.mycompany.Controller;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-16T12:04:50", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, String> EstadoEvento;
    public static volatile SingularAttribute<Evento, String> NombreEvento;
    public static volatile SingularAttribute<Evento, String> LugarEvento;
    public static volatile SingularAttribute<Evento, String> TipoPaquete;
    public static volatile SingularAttribute<Evento, Integer> id;
    public static volatile SingularAttribute<Evento, Date> FechaEvento;
    public static volatile SingularAttribute<Evento, String> MetodoPago;

}