import { Component, OnInit } from '@angular/core';
import SockJS from 'sockjs-client/dist/sockjs';
import { Stomp } from '@stomp/stompjs';

@Component({
  selector: 'app-root',
  template: `<h1>UART WebSocket Test (Angular)</h1>`,
})
export class AppComponent implements OnInit {
  private stompClient = Stomp.over(() => new SockJS('/ws'));

  ngOnInit() {
    this.stompClient.onConnect = (frame) => {
      console.log('✅ Connected to WebSocket:', frame);

      this.stompClient.subscribe('/topic/data', (message) => {
        console.log('📡 Received sensor data:', JSON.parse(message.body));
      });
    };

    this.stompClient.onStompError = (frame) => {
      console.error('❌ STOMP error:', frame);
    };

    this.stompClient.activate();
  }
}
