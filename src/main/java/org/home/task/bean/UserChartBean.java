package org.home.task.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.home.task.entity.User;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "userChart")
@ViewScoped
public class UserChartBean {

	@ManagedProperty(value = "#{user}")
	private UserManagedBean userManagedBean;

	private PieChartModel pieChartModel;

	public UserChartBean() {
		createUserPieChart();
	}

	public UserManagedBean getUserManagedBean() {
		return userManagedBean;
	}

	public void setUserManagedBean(UserManagedBean userManagedBean) {
		this.userManagedBean = userManagedBean;
	}

	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	public void createUserPieChart() {
		this.pieChartModel = new PieChartModel();

		int group1 = 0;
		int group2 = 0;
		int group3 = 0;

		int usernameLength;
		for (User user : this.userManagedBean.getUsers()) {
			usernameLength = user.getUsername().length();
			if (usernameLength > 2 && usernameLength < 5) {
				group1++;
			} else if (usernameLength > 4 && usernameLength < 7) {
				group2++;
			} else if (usernameLength > 6 && usernameLength < 9) {
				group3++;
			}
		}

		this.pieChartModel.set("3-4 symbols", group1);
		this.pieChartModel.set("5-6 symbols", group2);
		this.pieChartModel.set("7-8 symbols", group3);
	}
}
