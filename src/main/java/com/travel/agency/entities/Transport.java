package com.travel.agency.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the transports database table.
 * 
 */
@Entity
@Table(name="transports")
@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "getAllTransport",
            query   =   "SELECT * " +
                        "FROM transports",
                        resultClass=Transport.class
    ),
    @NamedNativeQuery(
            name	=   "getAllByIdTransport",
            query   =   "SELECT * " +
                        "FROM transports " +
                        "WHERE id = :id",
                        resultClass=Transport.class
    ),
    @NamedNativeQuery(
    		name	=	"getAllByFieldTransport",
    		query	=	"SELECT * "+
    					"FROM transports "+
    					"WHERE :nameColumn = :value",
    					resultClass=Transport.class
	)
})
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@Column(name="system_name")
	private String systemName;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="transport")
	private List<Order> orders;

	public Transport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setTransport(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setTransport(null);

		return order;
	}

}