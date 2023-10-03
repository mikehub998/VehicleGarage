package com.mb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mb.controller.Action;
import com.mb.controller.CrudController;
import com.mb.controller.CustomerController;
import com.mb.persistence.dao.CustomerDAO;
import com.mb.persistence.domain.Domain;
import com.mb.utils.DBUtils;
import com.mb.utils.Utils;

public class GarageSystem {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	// private final VehicleController products;
	// private final OrderController orders;
	// private final OrderlineController orderlines;


	private final Utils utils;

	public GarageSystem() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);

		// final ProductDAO prodDAO = new ProductDAO();
		// this.products = new ProductController(prodDAO, utils);

		// final OrderDAO orderDAO = new OrderDAO();
		// this.orders = new OrderController(orderDAO, utils);

		// final OrderlineDAO orderlineDAO = new OrderlineDAO();
		// this.orderlines = new OrderlineController(orderlineDAO, utils);
	}

	public void garageSystemMenu() {
		LOGGER.info("Welcome to the Garage here you can find a great range of vehicles in all styles and sizes!\n");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which of the following entities would you like to interact with? Please type the entity to select it.\n");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CUSTOMER:
				active = this.customers;
				break;
			// case PRODUCT:
			// 	active = this.products;
			// 	break;
			// case ORDER:
			// 	active = this.orders;
			// 	break;
			// case ORDERLINE:
			// 	active = this.orderlines;
			// 	break;
				case STOP:
					return;
				default:
					break;
			}

			LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ": ");

			Action.printActions();
			Action action = Action.getAction(utils);

			if (action == Action.RETURN) {
				changeDomain = true;
			} else {
				doAction(active, action);
			}
		} while (!changeDomain);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}
