package com.library.repository;

public class BookRepository {
	private int RepoID;
	private String RepoName;
	
	public int getRepoID() {
		return RepoID;
	}
	public void setRepoID(int repoID) {
		RepoID = repoID;
	}
	public String getRepoName() {
		return RepoName;
	}
	public void setRepoName(String repoName) {
		RepoName = repoName;
	}
	@Override
	public String toString() {
		return "BookRepository [RepoID=" + RepoID + ", RepoName=" + RepoName + "]";
	}
	
}
