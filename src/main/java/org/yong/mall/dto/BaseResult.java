package org.yong.mall.dto;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {
	private static final long serialVersionUID = 7431354778565785195L;

	private boolean success;

	private T data;

	private String info;

	public BaseResult(boolean success, String info) {
		this.success = success;
		this.info = info;
	}

	public BaseResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "BaseResult [success=" + success + ", data=" + data + ", info=" + info + "]";
	}

}
