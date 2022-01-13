<petclinic:layout pageName="Products">


    <jsp:body>

        <h2>Product</h2>
        <form:form modelAttribute="product" class="form-horizontal">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Name" name="name" />
                <petclinic:inputField label="Price" name="price" />
                <div class="control-group">
                    <petclinic:selectField name="productType" label="Product Type" names="${productType}" size="3" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="id" value="${card.id}"/>
                    <button class="btn btn-default" type="submit">Add Product</button>
                </div>
            </div>
        </form:form>
    </jsp:body>

</petclinic:layout>