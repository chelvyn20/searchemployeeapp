package com.example.searchemployeeapp.common;

abstract class Failure {
  final String message;

  public Failure(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}

class ServerFailure extends Failure {
  public ServerFailure(String message) {
    super(message);
  }
}

class DatabaseFailure extends Failure {
  public DatabaseFailure(String message) {
    super(message);
  }
}