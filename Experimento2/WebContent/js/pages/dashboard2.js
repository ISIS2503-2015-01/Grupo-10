'use strict';
$(function () {

  /* ChartJS
   * -------
   * Here we will create a few charts using ChartJS
   */


  //---------------------------
  //- END MONTHLY SALES CHART -
  //---------------------------

  //-------------
  //- PIE CHART -
  //-------------
  // Get context with jQuery - using jQuery's .get() method.
  var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
  var pieChart = new Chart(pieChartCanvas);
  var PieData = [
    {
      value: 400/10,
      color: "#2E0854",
      highlight: "#2E0876",
      label: "No Farmacologico"
    },
    {
      value: 150/10,
      color: "#71637D",
      highlight: "#71639E",
      label: "Antiinflamatorios no Esteroideos"
    },
    {
      value: 120/10,
      color: "#912CEE",
      highlight: "#912CFF",
      label: "Triptanes"
    },
    {
      value: 120/10,
      color: "#754C78",
      highlight: "#754C9A",
      label: "Ergotamina"
    },
    {
      value: 110/10,
      color: "#CDB5CD",
      highlight: "#CDB5EF",
      label: "Betabloqueantes"
    },
    {
      value: 70/10,
      color: "#584E56",
      highlight: "#584E78",
      label: "Anticonvulsivantes"
    },
	{
		value: 30/10,
		color: "#8B5F65",
		highlight: "#8B5F87",
		label: "Otros"
	}
  ];
  var pieOptions = {
    //Boolean - Whether we should show a stroke on each segment
    segmentShowStroke: true,
    //String - The colour of each segment stroke
    segmentStrokeColor: "#fff",
    //Number - The width of each segment stroke
    segmentStrokeWidth: 1,
    //Number - The percentage of the chart that we cut out of the middle
    percentageInnerCutout: 50, // This is 0 for Pie charts
    //Number - Amount of animation steps
    animationSteps: 100,
    //String - Animation easing effect
    animationEasing: "easeOutBounce",
    //Boolean - Whether we animate the rotation of the Doughnut
    animateRotate: true,
    //Boolean - Whether we animate scaling the Doughnut from the centre
    animateScale: false,
    //Boolean - whether to make the chart responsive to window resizing
    responsive: true,
    // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
    maintainAspectRatio: false,
    //String - A legend template
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>",
    //String - A tooltip template
    tooltipTemplate:"<%=label%>: <%=value %>%"
  };
  //Create pie or douhnut chart
  // You can switch between pie and douhnut using the method below.  
  pieChart.Doughnut(PieData, pieOptions);
  //-----------------
  //- END PIE CHART -
  //-----------------





});