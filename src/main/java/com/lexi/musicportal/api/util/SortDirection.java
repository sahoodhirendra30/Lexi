package com.lexi.musicportal.api.util;

public enum SortDirection {

	ASC, DESC;

	public static SortDirection fromString(String value) {

		try {
			return SortDirection.valueOf(value.toUpperCase());
		} catch (Exception e) {
			return null;
		}

	}
}
