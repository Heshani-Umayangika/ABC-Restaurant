<%-- 
    Document   : dashboard
    Created on : Mar 17, 2024, 6:10:52 PM
    Author     : Kelum
--%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    
    .card {
        margin-bottom: 1rem;
    }
    .card-header {
        background-color: black;
        color: whitesmoke;
        font-size: 1.5rem;
        font-weight: bold;
    }
    .card-body {
        text-align: center;
        font-size: 2rem;
        color: #063970;

    }
    .chart {
        height: 200px;
        margin-top: 1rem;
    }
    .icon {
        float: right;
        font-size: 3rem;
        color: #063970;
    }
    .table {
        margin-top: 1rem;
        font-size: 1rem;

    }
</style>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="card">
                <div class="card-header">Earnings</div>
                <div class="card-body text-success">${dailySummary.total_income_today}<i class="fa-solid fa-hand-holding-dollar icon text-success"></i></div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-header">Customers</div>
                <div class="card-body text-primary">${dailySummary.total_customers} <i class="fa-solid fa-user-group icon text-primary"></i></div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-header">Reservations</div>
                <div class="card-body text-warning">${dailySummary.total_reservations_today} <i class="fa-solid fa-calendar-days icon text-warning"></i></div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-header">Completed</div>
                <div class="card-body text-danger">${dailySummary.total_paid_reservations_today} <i class="fa-solid fa-calendar-check icon text-danger"></i></div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Latest Dine-In</div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Service</th>
                            </tr>
                        </thead>
                        <tbody>

                            <jstl:forEach var="item" items="${dineInList}" >
                                <tr>
                                    <td>${item.reservation_id}</td>
                                    <td>${item.reservation_date}</td>
                                    <td>${item.reservation_time}</td>
                                    <td>${item.service_name}</td>
                                </tr>
                            </jstl:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Latest Delivery</div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Service</th>
                            </tr>
                        </thead>
                        <tbody>
                            <jstl:forEach var="item" items="${deliveryList}" >
                                <tr>
                                    <td>${item.reservation_id}</td>
                                    <td>${item.reservation_date}</td>
                                    <td>${item.reservation_time}</td>
                                    <td>${item.service_name}</td>
                                </tr>
                            </jstl:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>



    <div class="row"><!--
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">Popular Services</div>
                <div class="card-body">
                    <canvas id="pieChart" class="chart"></canvas>
                </div>
            </div>
        </div>-->
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Last Month</div>
                <div class="card-body">
                    <canvas id="chart2" class="chart"></canvas>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">This Month</div>
                <div class="card-body">
                    <canvas id="chart3" class="chart"></canvas>
                </div>
            </div>
        </div>
    </div>



</div>

<script>
    // Chart 1
//    var LabelArray = ;
//    var DataArray = ;
//    var ctxPie = $('#pieChart');
//    var pieChart = new Chart(ctxPie, {
//        type: 'doughnut',
//        data: {
//            labels: ${popularTestNames},
//            datasets: [{
//                    label: 'Pie Chart Data',
//                    data: ${popularTestCounts},
//                    backgroundColor: [
//                        'rgba(255, 99, 132, 0.5)',
//                        'rgba(54, 162, 235, 0.5)',
//                        'rgba(255, 206, 86, 0.5)',
//                        'rgba(75, 192, 192, 0.5)',
//                        'rgba(153, 102, 255, 0.5)',
//                        'rgba(255, 159, 64, 0.5)',
//                        'rgba(255, 99, 132, 0.5)',
//                        'rgba(54, 162, 235, 0.5)',
//                        'rgba(255, 206, 86, 0.5)',
//                        'rgba(75, 192, 192, 0.5)',
//                        'rgba(153, 102, 255, 0.5)',
//                        'rgba(255, 159, 64, 0.5)',
//                        'rgba(255, 99, 132, 0.5)',
//                        'rgba(54, 162, 235, 0.5)',
//                        'rgba(255, 206, 86, 0.5)',
//                        'rgba(75, 192, 192, 0.5)',
//                        'rgba(153, 102, 255, 0.5)',
//                        'rgba(255, 159, 64, 0.5)',
//                        'rgba(255, 99, 132, 0.5)',
//                        'rgba(54, 162, 235, 0.5)'
//                    ],
//                    borderColor: [
//                        'rgba(255, 99, 132, 1)',
//                        'rgba(54, 162, 235, 1)',
//                        'rgba(255, 206, 86, 1)',
//                        'rgba(75, 192, 192, 1)',
//                        'rgba(153, 102, 255, 1)',
//                        'rgba(255, 159, 64, 1)',
//                        'rgba(255, 99, 132, 1)',
//                        'rgba(54, 162, 235, 1)',
//                        'rgba(255, 206, 86, 1)',
//                        'rgba(75, 192, 192, 1)',
//                        'rgba(153, 102, 255, 1)',
//                        'rgba(255, 159, 64, 1)',
//                        'rgba(255, 99, 132, 1)',
//                        'rgba(54, 162, 235, 1)',
//                        'rgba(255, 206, 86, 1)',
//                        'rgba(75, 192, 192, 1)',
//                        'rgba(153, 102, 255, 1)',
//                        'rgba(255, 159, 64, 1)',
//                        'rgba(255, 99, 132, 1)',
//                        'rgba(54, 162, 235, 1)'
//                    ],
//                    borderWidth: 1
//                }]
//        },
//        options: {
//            scales: {
//                y: {
//                    display: false
//                },
//                x: {
//                    display: false
//                }
//            }
//        }
//    });

    // Chart 2
    var ctx2 = $('#chart2');
    var chart2 = new Chart(ctx2, {
        type: 'line',
        data: {
            labels: ${lastMonthDays},
            datasets: [{
                    label: 'Chart 2 Data',
                    data: ${lastMonthCounts},
                    borderColor: 'rgba(0, 255, 0, 1)',
                    backgroundColor: 'rgba(0, 255, 0, 0.1)',
                    borderWidth: 2,
                    fill: true
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // Chart 3
    var ctx3 = $('#chart3');
    var chart3 = new Chart(ctx3, {
        type: 'line',
        data: {
            labels: ${thisMonthDays},
            datasets: [{
                    label: 'Chart 3 Data',
                    data: ${thisMonthCounts},
                    borderColor: 'rgba(0, 0, 255, 1)',
                    backgroundColor: 'rgba(0, 0, 255, 0.1)',
                    borderWidth: 2,
                    fill: true
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>