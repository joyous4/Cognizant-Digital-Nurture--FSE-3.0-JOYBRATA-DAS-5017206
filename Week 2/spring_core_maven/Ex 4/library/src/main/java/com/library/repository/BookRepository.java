package com.library.repository;


public class BookRepository {
	private int RepoID;
	private String RepoName;
	
	public BookRepository(int repoID, String repoName) {
		RepoID = repoID;
		RepoName = repoName;
	}
	@Override
	public String toString() {
		return "BookRepository [RepoID=" + RepoID + ", RepoName=" + RepoName + "]";
	}
	public String someRepositoryMethod() {
        return "BookRepository is working!";
    }
}
