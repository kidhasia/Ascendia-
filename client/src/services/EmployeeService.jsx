import axios from "axios";

//Nethuni
const REST_API_BASE_URL0 = "http://localhost:8080/api/users/";

export const getUserDetails = (userId) =>
  axios.get(REST_API_BASE_URL0 + userId);

export const getAllAvailableUsers = () =>
  axios.get(REST_API_BASE_URL0 + "all/available");

const REST_API_BASE_URL1 = "http://localhost:8080/api/project/user/";

export const addAssignment = (assignment) =>
  axios.post(REST_API_BASE_URL1 + "add", assignment);

export const deleteAssignment = (assignmentId) =>
  axios.delete(REST_API_BASE_URL1 + "remove/" + assignmentId);

export const getAllEmployeesForProject = (projectId) =>
  axios.get(REST_API_BASE_URL1 + projectId + "/all");

export const searchAssignment = (projectId, query) =>
  axios.get(REST_API_BASE_URL1 + "search/" + projectId + "?query=" + query);

const REST_API_BASE_URL2 = "http://localhost:8080/api/history/";

export const getAllPreviousEmployees = (projectId) =>
  axios.get(REST_API_BASE_URL2 + projectId + "/records");

export const getDurationForEmployee = (recordId) =>
  axios.get(REST_API_BASE_URL2 + recordId + "/duration");

export const searchHistory = (projectId, query) =>
  axios.get(REST_API_BASE_URL2 + "search/" + projectId + "?query=" + query);
