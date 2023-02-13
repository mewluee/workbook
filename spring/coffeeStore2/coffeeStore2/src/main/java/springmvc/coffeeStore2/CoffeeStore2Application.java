package springmvc.coffeeStore2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration : 자동 구성 메카니즘 활성화
//@ComponentScan : 컴포넌트 애너테이션이 붙은 클래스들에 대한 스캐닝 활성화
//@SpringBootConfiguration : Spring context에서 빈을 추가적으로 등록하거나 Configuration클래스를 추가적으로 임포트하는 기능 활성화
@SpringBootApplication
public class CoffeeStore2Application {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeStore2Application.class, args);
	}
	//run메서드를 호출하면 부트스트랩이 진행됨
	//과정
	//클래스 패스 내에서 ApplicationContext 인스턴스를 생성한다.
	//커맨드라인 매개 변수들을 Spring의 프로퍼티로 구성하기 위해 CommandLinePropertySource를 등록한다.
	//모든 싱글톤 bean들을 로드한 후, 애플리케이션 컨텍스트를 갱신한다.
	//CommandLineRunner bean들이 존재한다면 트리거(Trigger) 시킨다.
}
