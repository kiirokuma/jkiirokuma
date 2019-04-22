# JkiirokumaService

## アーキテクチャ

### ServiceProesser

#### Initial

ApiRequestをServiceInputに変換

​	Input		final ApiRequest

​	Input		final ServiceInput

​	Output	ServiceInput

#### Validation

Validation処理

​	Input		final ServiceInput 

​	Output	none

​	throws	ServiceException

#### Execution

サービス処理

​	Input		final ServiceInput 

​	Output	ServiceOutput

​	throws	ServiceException

#### End

ServiceOutputをApiResponceに変換

​	input		final ApiRequest

​	Input		final ServiceInput

​	Input		final ServiceOutput 

​	Output	ApiResponce



```java
SampleLogic sampleLogic = new SampleLogic();

public ServiceProesser getSampleApiProesser() {
    ServiceProesser serviceProesser = new ServiceProesser(
            ApiRequest.class, ApiResponce.class
        ,   ServiceInput.class, ServiceOutput.class);

    serviceProesser
      .addInitial("Init", (request,input) -> { return sampleLogic.initial(request); })
      .addValidation("Check1", (input) -> { sampleLogic.validation1(input); })
      .addValidation("Check2", (input) -> { sampleLogic.validation2(input); })
      .addExecution("Sample", (input) -> { sampleLogic.execution(input); })
      .addEnd("End", (request,input,output) -> { return sampleLogic.end(output); });
    return serviceProesser;
}

// API Call
public ApiResponce sampleApi(final ApiRequest request) {
    ApiResponce responce = getSampleApiProesser().run(request);
    return responce;
}

// API Info(JSON String)
public ApiResponce getSampleApiInfo(final ApiRequest request) {
    String jsonStr = serviceProesser.jsonString();
    return jsonStr;
}
```

