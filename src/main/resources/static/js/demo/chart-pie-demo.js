// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["서울", "경기", "대전", "대구", "부산", "광주", "충남", "충북", "강원", "전남"],
    datasets: [{
      data: [10,5,15,10,5,1,10,5,19,10],
      backgroundColor: ['#4e13df', '#1cc18a', '#46191c', '#4e73df', '#1cc88a', '#36b9cc', '#9e73df', '#9cc88a', '#96b9cc', '#9cc88a'],
      hoverBackgroundColor: ['#5e23ef', '#2cd19a', '#66393c', '#5e83ef', '#2cd89a', '#46c9dc', '#ae83ef', '#acd89a', '#a6c9dc', '#acd89a'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 70,
  },
});
