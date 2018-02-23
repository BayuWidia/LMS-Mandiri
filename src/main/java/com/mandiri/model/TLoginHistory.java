package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_login_history database table.
 * 
 */
@Entity
@Table(name="t_login_history")
@NamedQuery(name="TLoginHistory.findAll", query="SELECT t FROM TLoginHistory t")
public class TLoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login_history_id")
	private String loginHistoryId;

	private String ip;

	private Timestamp logged;

	private String type;

	private String username;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="user_nip")
	private Userprofile userprofile;

	public TLoginHistory() {
	}

	public String getLoginHistoryId() {
		return this.loginHistoryId;
	}

	public void setLoginHistoryId(String loginHistoryId) {
		this.loginHistoryId = loginHistoryId;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getLogged() {
		return this.logged;
	}

	public void setLogged(Timestamp logged) {
		this.logged = logged;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Userprofile getUserprofile() {
		return this.userprofile;
	}

	public void setUserprofile(Userprofile userprofile) {
		this.userprofile = userprofile;
	}

}