/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.v2.management.resources.implementation;

import com.microsoft.azure.v2.AzureProxy;
import com.microsoft.azure.v2.CloudException;
import com.microsoft.azure.v2.Page;
import com.microsoft.azure.v2.PagedList;
import com.microsoft.rest.v2.RestResponse;
import com.microsoft.rest.v2.ServiceCallback;
import com.microsoft.rest.v2.ServiceFuture;
import com.microsoft.rest.v2.annotations.DELETE;
import com.microsoft.rest.v2.annotations.ExpectedResponses;
import com.microsoft.rest.v2.annotations.GET;
import com.microsoft.rest.v2.annotations.HeaderParam;
import com.microsoft.rest.v2.annotations.Host;
import com.microsoft.rest.v2.annotations.PathParam;
import com.microsoft.rest.v2.annotations.PUT;
import com.microsoft.rest.v2.annotations.QueryParam;
import com.microsoft.rest.v2.annotations.UnexpectedResponseExceptionType;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/**
 * An instance of this class provides access to all the operations defined in
 * Tags.
 */
public class TagsInner {
    /**
     * The proxy service used to perform REST calls.
     */
    private TagsService service;

    /**
     * The service client containing this operation class.
     */
    private ResourceManagementClientImpl client;

    /**
     * Initializes an instance of TagsInner.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public TagsInner(ResourceManagementClientImpl client) {
        this.service = AzureProxy.create(TagsService.class, client);
        this.client = client;
    }

    /**
     * The interface defining all the services for Tags to be used by the proxy
     * service to perform REST calls.
     */
    @Host("https://management.azure.com")
    interface TagsService {
        @DELETE("subscriptions/{subscriptionId}/tagNames/{tagName}/tagValues/{tagValue}")
        @ExpectedResponses({200, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<RestResponse<Void, Void>> deleteValue(@PathParam("tagName") String tagName, @PathParam("tagValue") String tagValue, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage);

        @PUT("subscriptions/{subscriptionId}/tagNames/{tagName}/tagValues/{tagValue}")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<RestResponse<Void, TagValueInner>> createOrUpdateValue(@PathParam("tagName") String tagName, @PathParam("tagValue") String tagValue, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage);

        @PUT("subscriptions/{subscriptionId}/tagNames/{tagName}")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<RestResponse<Void, TagDetailsInner>> createOrUpdate(@PathParam("tagName") String tagName, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage);

        @DELETE("subscriptions/{subscriptionId}/tagNames/{tagName}")
        @ExpectedResponses({200, 204})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<RestResponse<Void, Void>> delete(@PathParam("tagName") String tagName, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage);

        @GET("subscriptions/{subscriptionId}/tagNames")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<RestResponse<Void, PageImpl<TagDetailsInner>>> list(@PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage);

        @GET("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<RestResponse<Void, PageImpl<TagDetailsInner>>> listNext(@PathParam(value = "nextUrl", encoded = true) String nextUrl, @HeaderParam("accept-language") String acceptLanguage);
    }

    /**
     * Deletes a tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    public void deleteValue(String tagName, String tagValue) {
        deleteValueAsync(tagName, tagValue).blockingAwait();
    }

    /**
     * Deletes a tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Void&gt;} object.
     */
    public ServiceFuture<Void> deleteValueAsync(String tagName, String tagValue, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(deleteValueAsync(tagName, tagValue), serviceCallback);
    }

    /**
     * Deletes a tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, Void&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Void>> deleteValueWithRestResponseAsync(String tagName, String tagValue) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (tagValue == null) {
            throw new IllegalArgumentException("Parameter tagValue is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.deleteValue(tagName, tagValue, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage());
    }

    /**
     * Deletes a tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Completable} object if successful.
     */
    public Completable deleteValueAsync(String tagName, String tagValue) {
        return deleteValueWithRestResponseAsync(tagName, tagValue)
            .toCompletable();
    }

    /**
     * Creates a tag value. The name of the tag must already exist.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the TagValueInner object if successful.
     */
    public TagValueInner createOrUpdateValue(String tagName, String tagValue) {
        return createOrUpdateValueAsync(tagName, tagValue).blockingGet();
    }

    /**
     * Creates a tag value. The name of the tag must already exist.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to create.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;TagValueInner&gt;} object.
     */
    public ServiceFuture<TagValueInner> createOrUpdateValueAsync(String tagName, String tagValue, final ServiceCallback<TagValueInner> serviceCallback) {
        return ServiceFuture.fromBody(createOrUpdateValueAsync(tagName, tagValue), serviceCallback);
    }

    /**
     * Creates a tag value. The name of the tag must already exist.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, TagValueInner&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, TagValueInner>> createOrUpdateValueWithRestResponseAsync(String tagName, String tagValue) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (tagValue == null) {
            throw new IllegalArgumentException("Parameter tagValue is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.createOrUpdateValue(tagName, tagValue, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage());
    }

    /**
     * Creates a tag value. The name of the tag must already exist.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Maybe&lt;TagValueInner&gt;} object if successful.
     */
    public Maybe<TagValueInner> createOrUpdateValueAsync(String tagName, String tagValue) {
        return createOrUpdateValueWithRestResponseAsync(tagName, tagValue)
            .flatMapMaybe(new Function<RestResponse<Void, TagValueInner>, Maybe<TagValueInner>>() {
                public Maybe<TagValueInner> apply(RestResponse<Void, TagValueInner> restResponse) {
                    if (restResponse.body() == null) {
                        return Maybe.empty();
                    } else {
                        return Maybe.just(restResponse.body());
                    }
                }
            });
    }

    /**
     * Creates a tag in the subscription.
     * The tag name can have a maximum of 512 characters and is case insensitive. Tag names created by Azure have prefixes of microsoft, azure, or windows. You cannot create tags with one of these prefixes.
     *
     * @param tagName The name of the tag to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the TagDetailsInner object if successful.
     */
    public TagDetailsInner createOrUpdate(String tagName) {
        return createOrUpdateAsync(tagName).blockingGet();
    }

    /**
     * Creates a tag in the subscription.
     * The tag name can have a maximum of 512 characters and is case insensitive. Tag names created by Azure have prefixes of microsoft, azure, or windows. You cannot create tags with one of these prefixes.
     *
     * @param tagName The name of the tag to create.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;TagDetailsInner&gt;} object.
     */
    public ServiceFuture<TagDetailsInner> createOrUpdateAsync(String tagName, final ServiceCallback<TagDetailsInner> serviceCallback) {
        return ServiceFuture.fromBody(createOrUpdateAsync(tagName), serviceCallback);
    }

    /**
     * Creates a tag in the subscription.
     * The tag name can have a maximum of 512 characters and is case insensitive. Tag names created by Azure have prefixes of microsoft, azure, or windows. You cannot create tags with one of these prefixes.
     *
     * @param tagName The name of the tag to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, TagDetailsInner&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, TagDetailsInner>> createOrUpdateWithRestResponseAsync(String tagName) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.createOrUpdate(tagName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage());
    }

    /**
     * Creates a tag in the subscription.
     * The tag name can have a maximum of 512 characters and is case insensitive. Tag names created by Azure have prefixes of microsoft, azure, or windows. You cannot create tags with one of these prefixes.
     *
     * @param tagName The name of the tag to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Maybe&lt;TagDetailsInner&gt;} object if successful.
     */
    public Maybe<TagDetailsInner> createOrUpdateAsync(String tagName) {
        return createOrUpdateWithRestResponseAsync(tagName)
            .flatMapMaybe(new Function<RestResponse<Void, TagDetailsInner>, Maybe<TagDetailsInner>>() {
                public Maybe<TagDetailsInner> apply(RestResponse<Void, TagDetailsInner> restResponse) {
                    if (restResponse.body() == null) {
                        return Maybe.empty();
                    } else {
                        return Maybe.just(restResponse.body());
                    }
                }
            });
    }

    /**
     * Deletes a tag from the subscription.
     * You must remove all values from a resource tag before you can delete it.
     *
     * @param tagName The name of the tag.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    public void delete(String tagName) {
        deleteAsync(tagName).blockingAwait();
    }

    /**
     * Deletes a tag from the subscription.
     * You must remove all values from a resource tag before you can delete it.
     *
     * @param tagName The name of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Void&gt;} object.
     */
    public ServiceFuture<Void> deleteAsync(String tagName, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(deleteAsync(tagName), serviceCallback);
    }

    /**
     * Deletes a tag from the subscription.
     * You must remove all values from a resource tag before you can delete it.
     *
     * @param tagName The name of the tag.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, Void&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Void>> deleteWithRestResponseAsync(String tagName) {
        if (tagName == null) {
            throw new IllegalArgumentException("Parameter tagName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.delete(tagName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage());
    }

    /**
     * Deletes a tag from the subscription.
     * You must remove all values from a resource tag before you can delete it.
     *
     * @param tagName The name of the tag.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Completable} object if successful.
     */
    public Completable deleteAsync(String tagName) {
        return deleteWithRestResponseAsync(tagName)
            .toCompletable();
    }

    /**
     * Gets the names and values of all resource tags that are defined in a subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the PagedList&lt;TagDetailsInner&gt; object if successful.
     */
    public PagedList<TagDetailsInner> list() {
        Page<TagDetailsInner> response = listSinglePageAsync().blockingGet();
        return new PagedList<TagDetailsInner>(response) {
            @Override
            public Page<TagDetailsInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).blockingGet();
            }
        };
    }

    /**
     * Gets the names and values of all resource tags that are defined in a subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the observable to the PagedList&lt;TagDetailsInner&gt; object.
     */
    public Observable<Page<TagDetailsInner>> listAsync() {
        return listSinglePageAsync()
            .toObservable()
            .concatMap(new Function<Page<TagDetailsInner>, Observable<Page<TagDetailsInner>>>() {
                @Override
                public Observable<Page<TagDetailsInner>> apply(Page<TagDetailsInner> page) {
                    String nextPageLink = page.nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the names and values of all resource tags that are defined in a subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;Page&lt;TagDetailsInner&gt;&gt;} object if successful.
     */
    public Single<Page<TagDetailsInner>> listSinglePageAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage()).map(new Function<RestResponse<Void, PageImpl<TagDetailsInner>>, Page<TagDetailsInner>>() {
            @Override
            public Page<TagDetailsInner> apply(RestResponse<Void, PageImpl<TagDetailsInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets the names and values of all resource tags that are defined in a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the PagedList&lt;TagDetailsInner&gt; object if successful.
     */
    public PagedList<TagDetailsInner> listNext(final String nextPageLink) {
        Page<TagDetailsInner> response = listNextSinglePageAsync(nextPageLink).blockingGet();
        return new PagedList<TagDetailsInner>(response) {
            @Override
            public Page<TagDetailsInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).blockingGet();
            }
        };
    }

    /**
     * Gets the names and values of all resource tags that are defined in a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the observable to the PagedList&lt;TagDetailsInner&gt; object.
     */
    public Observable<Page<TagDetailsInner>> listNextAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .toObservable()
            .concatMap(new Function<Page<TagDetailsInner>, Observable<Page<TagDetailsInner>>>() {
                @Override
                public Observable<Page<TagDetailsInner>> apply(Page<TagDetailsInner> page) {
                    String nextPageLink = page.nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the names and values of all resource tags that are defined in a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;Page&lt;TagDetailsInner&gt;&gt;} object if successful.
     */
    public Single<Page<TagDetailsInner>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage()).map(new Function<RestResponse<Void, PageImpl<TagDetailsInner>>, Page<TagDetailsInner>>() {
            @Override
            public Page<TagDetailsInner> apply(RestResponse<Void, PageImpl<TagDetailsInner>> response) {
                return response.body();
            }
        });
    }
}
