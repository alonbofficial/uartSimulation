import { Component, OnInit, ViewChild } from '@angular/core';
import SockJS from 'sockjs-client/dist/sockjs';
import { Stomp } from '@stomp/stompjs';
import { ChartOptions, ChartData } from 'chart.js';
import { NgChartsModule, BaseChartDirective } from 'ng2-charts';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  standalone: true,
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [NgChartsModule],
})
export class AppComponent implements OnInit {
  @ViewChild(BaseChartDirective) chart?: BaseChartDirective;
  private stompClient = Stomp.over(() => new SockJS('https://ubiquitous-space-xylophone-95q55gjprgq39p5g-8080.app.github.dev/ws'));

  constructor(private cdr: ChangeDetectorRef) {}

  chartLabels: string[] = [];
  chartData: ChartData<'line'> = {
    labels: this.chartLabels,
    datasets: [
      {
        label: 'Temperature (°C)',
        data: [],
        tension: 0.4,
        borderColor: 'rgb(255, 99, 132)',
      },
      {
        label: 'Humidity (%)',
        data: [],
        tension: 0.4,
        borderColor: 'rgb(54, 162, 235)',
      },
    ],
  };

  chartOptions: ChartOptions = {
    responsive: true,
    animation: false,
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  };

  ngOnInit() {
    this.stompClient.onConnect = (frame) => {
      console.log('✅ Connected to WebSocket:', frame);

      this.stompClient.subscribe('/topic/data', (message) => {
        const data = JSON.parse(message.body);
        const timestamp = new Date().toLocaleTimeString();

        const temperature = data.sensorData.temperature;
        const humidity = data.sensorData.humidity;

        console.log(
          `📊 Data received: ${timestamp} - Temperature: ${temperature}°C, Humidity: ${humidity}%`
        );

        this.chartData.labels!.push(timestamp);
        this.chartData.datasets[0].data.push(temperature);
        this.chartData.datasets[1].data.push(humidity);

        // Keep only last 10 points
        if (this.chartData.labels!.length > 20) {
          this.chartData.labels!.shift();
          this.chartData.datasets[0].data.shift();
          this.chartData.datasets[1].data.shift();
        }

        // Trigger change detection manually
        this.cdr.detectChanges();

        // Update the chart to reflect changes
        this.chart?.update();
      });
    };

    this.stompClient.onStompError = (frame) => {
      console.error('STOMP error:', frame);
    };

    this.stompClient.activate();
  }
}
